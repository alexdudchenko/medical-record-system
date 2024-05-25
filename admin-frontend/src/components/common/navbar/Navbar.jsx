import {Link} from "react-router-dom";
import {Box, Flex} from "@chakra-ui/react";
import useAuth from "../../../hooks/useAuth.js";

export default function Navbar() {
    const {auth} = useAuth();

    return (
        <Flex as="nav" bg="teal.500" p="6" alignItems="center" justifyContent="space-between">
            <Box>
                <Link to="/" color="white" mx={2}>
                    VitalTrack
                </Link>
            </Box>
            {
                auth?.id
                    ? (
                        <Flex justifyContent="space-between" gap="50px">
                            <Box>
                                <Link to="/verify" color="white" mx={2}>
                                    Verify
                                </Link>
                            </Box>
                            <Box>
                                <Link to="/doctors" color="white" mx={2}>
                                    Doctors
                                </Link>
                            </Box>
                            <Box>
                                <Link to="/patients" color="white" mx={2}>
                                    Patients
                                </Link>
                            </Box>
                            <Box>
                                <Link to="/hospitals" color="white" mx={2}>
                                    Hospitals
                                </Link>
                            </Box>
                            <Box>
                                <Link to="/specialisation" color="white" mx={2}>
                                    Specialisations
                                </Link>
                            </Box>
                        </Flex>
                    )
                    : (
                        <Flex justifyContent="space-between" gap="50px">
                            <Box>
                                <Link to="/login" color="white" mx={2}>
                                    Login
                                </Link>
                            </Box>
                        </Flex>
                    )
            }
        </Flex>
    )
}