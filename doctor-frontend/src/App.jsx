import './App.css'
import {Route, Routes} from "react-router-dom";
import {Flex} from "@chakra-ui/react";
import PatientsPage from "./components/patient/PatientsPage.jsx"
import Home from "./components/home/Home.jsx";
import Navbar from "./components/common/navbar/Navbar.jsx";
import ListMedicalRecordEntries from "./components/common/medical-record/ListMedicalRecordEntries.jsx";

function App() {

  return (
    <>
        <Flex direction="column" w="100%" justifyContent="flex-start" gap="10px">
            <Navbar/>
            <Routes>
                <Route path="/patients" element={<PatientsPage/>}/>
                <Route path="/" element={<Home/>}/>
                <Route path="/patients/:id/medical-record" element={<ListMedicalRecordEntries/>}/>
            </Routes>
        </Flex>
    </>
  )
}

export default App
