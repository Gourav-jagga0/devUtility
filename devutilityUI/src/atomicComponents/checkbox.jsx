import React from 'react';

function checkbox({ fieldName, label, formData, setFormData }) {
  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: type === "checkbox" ? checked : value,
    }));
  };

  return (
    <div className="flex items-center space-x-2">
        <input
        type="checkbox"
        id={fieldName}
        name={fieldName}
        checked={formData[fieldName]}
        onChange={handleChange}
        className="w-4 h-4"
        />
        <label htmlFor={fieldName} className="font-medium">{label}</label>
    </div>
  );
}

export default checkbox;
