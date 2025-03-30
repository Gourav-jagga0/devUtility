import Crypto from "./crypto";
import Keystore from "./keystore";
import { useAppContext } from "./home";

const Content = () => {
    const { selectedOption } = useAppContext();
    return (
        <>
            {selectedOption === "decryptPassword" && (
             <Crypto/>
            )}
            {selectedOption === "decryptKeystore" && (
                <Keystore/>
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