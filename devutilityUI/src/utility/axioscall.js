import { endpoints } from "./urlMap";
import axios from "axios";

//const baseUrl = `${window.location.protocol}//${window.location.host}`;
const baseUrl = "http://localhost:8080";

const callPost = (endPoint, payload,header) => {
  return axios.post(baseUrl + endpoints[endPoint], payload,{headers:header})
        .then(res => {
            if(res!=null && res.status===200){
                return res.data;
            }
            return "api call failled with status res.status "+res.status ;
        }) 
        .catch(error => {
            console.error("Oops, something went wrong", error);
            throw error;
        });
};

export { callPost };
