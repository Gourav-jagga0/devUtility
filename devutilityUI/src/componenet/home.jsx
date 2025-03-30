import React, { useState, createContext, useContext } from "react";
import Navbar from "./navbar";
import Content from "./content";
const AppContext = createContext();
export const AppProvider = ({ children }) => {
    const [selectedOption, setSelectedOption] = useState("decryptPassword");
    const [isSidebarOpen, setIsSidebarOpen] = useState(false);

    return (
        <AppContext.Provider value={{ isSidebarOpen, setIsSidebarOpen, selectedOption, setSelectedOption }}>
            {children}
        </AppContext.Provider>
    );
};
export const useAppContext = () => useContext(AppContext);
const Home = () => {
    return (
        <AppProvider> 
            <div className="flex h-screen bg-gray-100">
                <Navbar /> 
                <div className="flex-1 flex flex-col">
                    <div className="bg-blue-600 text-white p-4 text-xl font-bold shadow-md flex justify-center">
                        Dev Utility
                    </div>
                    <div className="flex-1 p-6 flex items-start justify-start">
                        <Content />
                    </div>
                </div>
            </div>
        </AppProvider>
    );
};

export default Home;