import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import {BrowserRouter} from "react-router-dom";
import {ChakraProvider} from "@chakra-ui/react";
import { AuthProvider } from "./context/AuthProvider.jsx";
import {QueryClient, QueryClientProvider} from "react-query";

const queryClient = new QueryClient()

ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <BrowserRouter>
            <ChakraProvider>
                <AuthProvider>
                    <QueryClientProvider client={queryClient}>
                        <App/>
                    </QueryClientProvider>
                </AuthProvider>
            </ChakraProvider>
        </BrowserRouter>
    </React.StrictMode>,
)
