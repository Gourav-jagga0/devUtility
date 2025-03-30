import { useState } from "react";
import Field from "../atomicComponents/field";
import { callPost } from "../utility/axioscall";

export default function keystoreForm() {
  debugger;
  const [formData, setFormData] = useState({
    keystoreFile:null
  });
  const [outputData, setoutputData] = useState(null);
  const handleSubmit = (e) => {
    if(!formData["keystoreFile"]){
      alert("Please enter a file")
      return;
    }
    e.preventDefault();
    let buttonname=event.submitter?.name;
    if(buttonname==="dec"){
      var filedata=new FormData();
      filedata.append("keystoreFile",formData["keystoreFile"]) ;
     callPost("decryptKeystore",filedata).then(res=> setoutputData(res));
    }
    console.log("Form Data:", outputData);
  };
  return (
    <>
    <div className="w-1/3 ml-0 p-6 shadow-lg rounded-2xl border border-gray-300">
      <form onSubmit={handleSubmit} className="space-y-4">
        <Field fieldName="keystoreFile" label="Upload Keystore File" formData={formData} setFormData={setFormData} type ="file" />
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
