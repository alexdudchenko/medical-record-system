import './App.css'
import {Flex} from "@chakra-ui/react";
import {Route, Routes} from 'react-router-dom'
import Navbar from "./components/common/navbar/Navbar.jsx";
import Home from "./components/home/Home.jsx";
import Login from "./components/common/login/Login.jsx";
import RequireAuth from "./components/common/login/RequireAuth.jsx";
import ListEntries from "./components/medical-record/ListEntries.jsx";
import MedicalEntryDetails from "./components/medical-record/MedicalEntryDetails.jsx";
import Registration from "./components/common/login/Registration.jsx";
import AccessControl from "./components/access-control/AccessControl.jsx";
import MyProfile from "./components/my-profile/MyProfile.jsx";
import ListVaccinations from "./components/vaccinations/ListVaccinations.jsx";
import ListPrescriptions from "./components/prescriptions/ListPrescriptions.jsx";
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

                    <Route element={<RequireAuth allowedRoles={["PATIENT"]}/>}>
                        <Route path="/medical-record" element={<ListEntries/>}/>
                        <Route path="/medical-record/:entryId" element={<MedicalEntryDetails/>}/>
                        <Route path="/access" element={<AccessControl/>}/>
                        <Route path="/my-profile" element={<MyProfile/>}/>
                        <Route path="/medical-record/vaccinations" element={<ListVaccinations/>}/>
                        <Route path="/medical-record/prescriptions" element={<ListPrescriptions/>}/>
                        <Route path="/medical-record/referrals" element={<ListReferrals/>}/>
                    </Route>
                </Routes>
            </Flex>
        </>
    )
}

export default App
