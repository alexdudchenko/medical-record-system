import {Link} from "react-router-dom";
import {Box, Flex} from "@chakra-ui/react";

export default function Navbar() {
    return (
        <Flex as="nav" bg="teal.500" p="4" alignItems="center" justifyContent="space-between">
            <Box>
                <Link to="/" color="white" mx={2}>
                    VitalTrack
                </Link>
            </Box>
            <Flex justifyContent="space-between" gap="50px">
                <Box>
                    <Link to="/" color="white" mx={2}>
                        Home
                    </Link>
                </Box>
                <Box>
                    <Link to="/patients" color="white" mx={2}>
                        Patients
                    </Link>
                </Box>
            </Flex>
        </Flex>
    )
}