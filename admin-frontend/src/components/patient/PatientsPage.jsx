import {useEffect, useState} from "react";
import UserProfilePreview from "../common/user-profile/UserProfilePreview.jsx";
import {Flex, Heading} from "@chakra-ui/react";
import {Link} from "react-router-dom";
import SearchBar from "../common/search/SearchBar.jsx";
import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";

export default function VerifyPage() {

    const axiosPrivate = useAxiosPrivate()
    const [patients, setPatients] = useState([])

    useEffect(() => {
        axiosPrivate.get("/patients")
            .then((response) => {
                    setPatients(response.data)
                }
            ).catch((error) => console.error(error)
        )
    }, []);

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