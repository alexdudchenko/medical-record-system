import './App.css'
import {Flex, VStack} from "@chakra-ui/react";
import {Route, Routes} from 'react-router-dom'
import Navbar from "./components/common/navbar/Navbar.jsx";
import PatientsPage from "./components/patient/PatientsPage.jsx";
import PatientDetails from "./components/patient/PatientDetails.jsx";
import Home from "./components/home/Home.jsx";
import Login from "./components/common/login/Login.jsx";
import RequireAuth from "./components/common/login/RequireAuth.jsx";
import ListEntries from "./components/medical-record/ListEntries.jsx";
import MedicalEntryDetails from "./components/medical-record/MedicalEntryDetails.jsx";
import CreateEntry from "./components/medical-record/CreateEntry.jsx";
import Registration from "./components/common/login/Registration.jsx";
import MyProfile from "./components/my-profile/MyProfile.jsx";
import ListVaccinations from "./components/vaccinations/ListVaccinations.jsx";
import CreateVaccination from "./components/vaccinations/CreateVaccination.jsx";
import CreatePrescription from "./components/prescriptions/CreatePrescription.jsx";
import ListPrescriptions from "./components/prescriptions/ListPrescriptions.jsx";
import CreateReferral from "./components/referrals/CreateReferral.jsx";
import ListReferrals from "./components/referrals/ListReferrals.jsx";

function App() {

    return (
        <>
            <Flex direction="column" w="100%" justifyContent="flex-start" gap="10px">
                <Navbar/>
                <Routes>
                    <Route path="/" element={<Home/>}/>
                    <Route path="/login" element={<Login/>}/>
                    <Route path="/signup" element={<Registration/>}/>

                    <Route element={<RequireAuth allowedRoles={["DOCTOR"]}/>}>
                        <Route path="/patients" element={<PatientsPage/>}/>
                        <Route path="/patients/:id" element={<PatientDetails/>}/>
                        <Route path="/patients/:id/medical-record" element={<ListEntries/>}/>
                        <Route path="/patients/:id/medical-record/:entryId" element={<MedicalEntryDetails/>}/>
                        <Route path="/patients/:id/medical-record/create" element={<CreateEntry/>}/>
                        <Route path="/patients/:id/medical-record/vaccinations" element={<ListVaccinations/>}/>
                        <Route path="/patients/:id/medical-record/vaccinations/create" element={<CreateVaccination/>}/>
                        <Route path="/patients/:id/medical-record/prescriptions" element={<ListPrescriptions/>}/>
                        <Route path="/patients/:id/medical-record/prescriptions/create" element={<CreatePrescription/>}/>
                        <Route path="/patients/:id/medical-record/referrals" element={<ListReferrals/>}/>
                        <Route path="/patients/:id/medical-record/referrals/create" element={<CreateReferral/>}/>
                        <Route path="/my-profile" element={<MyProfile/>}/>
                    </Route>
                </Routes>
            </Flex>
        </>
    )
}

export default App
