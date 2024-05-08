import {useEffect, useState} from "react";
import {getAllDoctors} from "../../service/DoctorService.js";
import UserProfilePreview from "../common/user-profile/UserProfilePreview.jsx";
import {Flex, Heading} from "@chakra-ui/react";
import {Link} from "react-router-dom";
import SearchBar from "../common/search/SearchBar.jsx";

export default function VerifyPage() {

    const [doctors, setDoctors] = useState([])

    useEffect(() => {
        getDoctors()
    }, []);

    function getDoctors() {
        getAllDoctors()
            .then((response) => {
                    setDoctors(response.data)
                }
            ).catch((error) => console.error(error)
        )
    }

    return (
        <>
            <Heading as="h1">Doctors</Heading>
            <SearchBar setData={setDoctors} searchCollection={"doctors"}/>
            <Flex wrap="wrap" justify="flex-start">
                {
                    doctors.map((doctor) => (
                        <Link key={doctor.id} to={`${doctor.id}`}>
                            <UserProfilePreview user={doctor}/>
                        </Link>
                    ))
                }
            </Flex>
        </>
    )
}