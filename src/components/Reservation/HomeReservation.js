import React from 'react'
import { Box, Paper } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
import { blue } from '@material-ui/core/colors';
import { Link } from 'react-router-dom';


const useStyles = makeStyles((theme) =>({
    root:{
        margin:theme.spacing(1),
        width:theme.spacing(100),
        height:theme.spacing(25),
        paddingLeft:theme.spacing(30),
        paddingTop:theme.spacing(20)
    },
    boxBorder:{
        border:`3px solid ${blue[200]}`
    }
}))
export default function HomeReservation() {
    const classes=useStyles()

    return (
        <>
        <div className='resroom'>
            <div style={{ maxWidth: "100%", width: "50%" }} className='container'>
            <h1 class='text-center' style={{color: "white",lineHeight:5}}>Reservation</h1> 
            <Paper variant='outlined'>
                    <Box p={1} className={classes.boxBorder} style={{ textAlign: "center" }}>
                        <Link className='addReservationLink' to='/middle/resroom/addReservation' style={{ color: "black", textDecoration: "none" }}>Booking</Link>
                </Box>
            </Paper>
            <br></br><br></br>
            <Paper variant='outlined'>
                    <Box p={1} className={classes.boxBorder} style={{ textAlign: "center" }}>
                        <Link className='getAllReservationLink' to='/middle/resroom/getAllReservation' style={{ color: "black", textDecoration: "none" }}>Booking Details</Link>
                </Box>
            </Paper>
        </div>
        </div>
        </>
    )
}