import React from 'react';

function Field({ fieldName, label, formData, setFormData ,type}) {
  const handleChange = (e) => {
    debugger;
    const { name, value, type, checked,files } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]:type === "file" ? files[0] : type === "checkbox" ? checked : value
      
    }));
  };

  return (
    <div>
      <label htmlFor={fieldName} className="block font-medium">{label}</label>
      <input
        id={fieldName}
        name={fieldName}
        onChange={handleChange}
        {...(type!="file" && formData && formData[fieldName] ? { value: formData[fieldName] } : {})} 
        className="w-full p-2 border rounded-md"
        type={type ||"text"}
      />
    </div>
  );
}

export default Field;
