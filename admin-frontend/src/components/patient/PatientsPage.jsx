import {useEffect, useState} from "react";
import UserProfilePreview from "../common/user-profile/UserProfilePreview.jsx";
import {Flex, Heading} from "@chakra-ui/react";
import {getAllPatients} from "../../service/PatientService.js";
import {Link} from "react-router-dom";
import SearchBar from "../common/search/SearchBar.jsx";

export default function VerifyPage() {

    const [patients, setPatients] = useState([])

    useEffect(() => {
        getPatients()
    }, []);

    function getPatients() {
        getAllPatients()
            .then((response) => {
                    setPatients(response.data)
                }
            ).catch((error) => console.error(error)
        )
    }

    return (
        <>
            <Heading as="h1">Patients</Heading>
            <SearchBar setData={setPatients} searchCollection={"patients"}/>
            <Flex wrap="wrap" justify="flex-start">
                {
                    patients.map((doctor) => (
                        <Link key={doctor.id} to={`${doctor.id}`}>
                            <UserProfilePreview user={doctor}/>
                        </Link>
                    ))
                }
            </Flex>
        </>
    )
}