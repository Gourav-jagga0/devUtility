import Crypto from "./crypto";
import { useAppContext } from "./home";

const Content = () => {
    const { selectedOption } = useAppContext();

    return (
        <>
            {selectedOption === "decryptPassword" && (
             <Crypto/>
            )}
            {selectedOption === "decryptKeystore" && (
                <h2 className="text-xl font-semibold text-gray-800">Decrypt Keystore File Screen</h2>
            )}
            {!selectedOption && (
                <h2 className="text-xl font-semibold text-gray-600">
                    Select an option from the sidebar
                </h2>
            )}
        </>
    );
};
export default Content;