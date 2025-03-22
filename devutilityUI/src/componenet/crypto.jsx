import { useState } from "react";
import Field from "../atomicComponents/field";
import { callPost } from "../utility/axioscall";

export default function EncryptionForm() {
  const [formData, setFormData] = useState({
    key: "",
    passPhrase: "",
    keyLength: "",
    iterationCount: "",
    salt: "",
    randomIv: false,
    encryptAlgo: "",
    algo: ""
  });
  const [showAdvanced, setShowAdvanced] = useState(false);
  const [outputData, setoutputData] = useState(null);
  const handleSubmit = (e) => {
    e.preventDefault();
    let buttonname=event.submitter?.name;
    if(buttonname==="dec"){
        if(showAdvanced){decrypt
        callPost("decrypt",formData).then(res=> setoutputData(res));
        }else{
        callPost("decryptAll",formData).then(res=> setoutputData(res));
        }
    }else if(buttonname==="enc"){
     callPost("encrypt",formData).then(res=> setoutputData(res));
    }
    console.log("Form Data:", outputData);
  };
  return (
    <>
    <div className="w-1/3 ml-0 p-6 shadow-lg rounded-2xl border border-gray-300">
      <form onSubmit={handleSubmit} className="space-y-4">
        <Field fieldName="key" label="Key" formData={formData} setFormData={setFormData}/>
        <button type="button" className="w-full mt-2 bg-blue-500 text-white p-2 rounded-md"
          onClick={() => setShowAdvanced(!showAdvanced)}
        >
          {showAdvanced ? "Hide Advanced Options" : "Show Advanced Options"}
        </button>
        {showAdvanced && (
          <div className="space-y-4 mt-4">
            <Field fieldName="passPhrase" label="Pass Phrase" formData={formData} setFormData={setFormData}/>
            <Field fieldName="keyLength" label="Key Length" formData={formData} setFormData={setFormData}/>
            <Field fieldName="iterationCount" label="Iteration Count" formData={formData} setFormData={setFormData}/>
            <Field fieldName="salt" label="Salt" formData={formData} setFormData={setFormData}/>
            <checkbox fieldName="salt" label="Salt" formData={formData} setFormData={setFormData}/>
            <Field fieldName="encryptAlgo" label="Encryption Algorithm" formData={formData} setFormData={setFormData}/>
            <Field fieldName="algo" label="Algorithm" formData={formData} setFormData={setFormData}/>
          </div>
        )}
        <button type="submit" name="enc" className="ml-20 w-1/3 bg-black text-white p-2 rounded-md">
          encrypt
        </button>
        <button type="submit" name="dec" className="m-1 w-1/3 bg-black text-white p-2 rounded-md">
          decrypt
        </button>
      </form>
    </div>
    <div className="w-2/3 ml-auto h-full p-6 shadow-lg rounded-2xl border border-gray-300">
    <pre className="bg-gray-100 p-4 rounded-md text-sm">
      {JSON.stringify(outputData, null, 2)}
    </pre>
    </div>
    </>
  );
}
