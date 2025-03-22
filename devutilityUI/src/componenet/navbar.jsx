import { useAppContext } from "./home";

import React, { useState } from "react";
import { FiMenu, FiLock, FiFile } from "react-icons/fi";
const Navbar = () => {
    const { isSidebarOpen, setIsSidebarOpen, selectedOption, setSelectedOption } = useAppContext();
  debugger;
    const toggleSidebar = () => {
        setIsSidebarOpen(!isSidebarOpen);
      };
  return (
    <div className={`bg-gray-900 text-white ${isSidebarOpen ? "w-64" : "w-20"} transition-all duration-300 flex flex-col p-4 shadow-lg`}> 
    <button onClick={toggleSidebar} className="mb-4 p-2 bg-gray-700 rounded-full hover:bg-gray-600 focus:outline-none transition-colors">
      <FiMenu size={24} />
    </button>
    {isSidebarOpen && <h2 className="text-lg font-bold mb-4">Utilities</h2>}
    <ul className="w-full">
      <li 
        onClick={() => setSelectedOption("decryptPassword")} 
        className={`flex items-center gap-2 py-2 px-4 rounded-lg cursor-pointer transition-colors ${selectedOption === "decryptPassword" ? "bg-blue-600" : "hover:bg-gray-700"}`}
      >
        <FiLock size={20} /> {isSidebarOpen && "Decrypt Password"}
      </li>
      <li 
        onClick={() => setSelectedOption("decryptKeystore")} 
        className={`flex items-center gap-2 py-2 px-4 rounded-lg cursor-pointer transition-colors ${selectedOption === "decryptKeystore" ? "bg-blue-600" : "hover:bg-gray-700"}`}
      >
        <FiFile size={20} /> {isSidebarOpen && "Decrypt Keystore File"}
      </li>
    </ul>
  </div>
  )
}
export default Navbar