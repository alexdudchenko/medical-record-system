import './App.css'
import {Flex} from "@chakra-ui/react";
import {Route, Routes} from 'react-router-dom'
import Navbar from "./components/common/navbar/Navbar.jsx";
import VerifyPage from "./components/verification/VerifyPage.jsx";
import DoctorsPage from "./components/doctor/DoctorsPage.jsx";
import PatientsPage from "./components/patient/PatientsPage.jsx";
import DoctorApplication from "./components/verification/DoctorApplication.jsx";
import DoctorDetails from "./components/doctor/DoctorDetails.jsx";
import PatientDetails from "./components/patient/PatientDetails.jsx";
import Home from "./components/home/Home.jsx";

function App() {

    return (
        <>
            <Flex direction="column" w="100%" justifyContent="flex-start" gap="10px">
                <Navbar/>
                <Routes>
                    <Route path="/verify" element={<VerifyPage/>}/>
                    <Route path="/doctors" element={<DoctorsPage/>}/>
                    <Route path="/patients" element={<PatientsPage/>}/>
                    <Route path="/verify/doctor/:id" element={<DoctorApplication/>}/>
                    <Route path="/doctors/:id" element={<DoctorDetails/>}/>
                    <Route path="/patients/:id" element={<PatientDetails/>}/>
                    <Route path="/" element={<Home/>}/>
                </Routes>
            </Flex>
        </>
    )
}

export default App
