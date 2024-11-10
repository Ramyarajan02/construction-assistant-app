import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler, OneHotEncoder
from sklearn.compose import ColumnTransformer
from sklearn.pipeline import Pipeline
from sklearn.ensemble import RandomForestRegressor
from skl2onnx import convert_sklearn
from skl2onnx.common.data_types import FloatTensorType

# Sample dataset (in place of loading from CSV)
data = pd.DataFrame({
    'land_area(sq. meters)': [500.0, 400.0, 800.0],
    'number_of_floors': [2, 1, 3],
    'number_of_rooms': [5, 3, 7],
    'House_Design': ['Simple', 'Medium', 'Modern'],
    'Bricks': [10000, 8000, 15000],
    'Cement': [500, 300, 700],
    'Steel': [2000, 1500, 2500],
    'Wood': [100, 80, 150]
})

# Define features (X) and target (y)
X = data[['land_area(sq. meters)', 'number_of_floors', 'number_of_rooms', 'House_Design']]
y = data[['Bricks', 'Cement', 'Steel', 'Wood']]

# Define preprocessing steps
numeric_features = ['land_area(sq. meters)', 'number_of_floors', 'number_of_rooms']
categorical_features = ['House_Design']

preprocessor = ColumnTransformer(
    transformers=[
        ('num', StandardScaler(), numeric_features),
        ('cat', OneHotEncoder(), categorical_features)
    ]
)

# Define the model pipeline
model = Pipeline(steps=[
    ('preprocessor', preprocessor),
    ('regressor', RandomForestRegressor(n_estimators=100, random_state=42))
])

# Split the data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Train the model
model.fit(X_train, y_train)

# Verify that all data is numeric after preprocessing
X_transformed = model.named_steps['preprocessor'].transform(X_train)
print("Transformed training data shape:", X_transformed.shape)

# Define initial type for ONNX export, matching transformed data shape
initial_type = [('float_input', FloatTensorType([None, X_transformed.shape[1]]))]

# Convert the model to ONNX format
converted_model = convert_sklearn(model, initial_types=initial_type)

# Save the ONNX model to disk
with open("sklearn_construction_model.onnx", "wb") as f:
    f.write(converted_model.SerializeToString())

print("Model successfully saved as sklearn_construction_model.onnx")
