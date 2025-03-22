import React from 'react';

function Field({ fieldName, label, formData, setFormData }) {
  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: type === "checkbox" ? checked : value,
    }));
  };

  return (
    <div>
      <label htmlFor={fieldName} className="block font-medium">{label}</label>
      <input
        id={fieldName}
        name={fieldName}
        value={formData[fieldName] || ""} 
        onChange={handleChange}
        className="w-full p-2 border rounded-md"
      />
    </div>
  );
}

export default Field;
