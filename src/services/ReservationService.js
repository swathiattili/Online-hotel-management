import axios from 'axios';
const RESERVATION_GET_ALL_URL='http://localhost:8084/reservation/get';
const RESERVATION_ADD_URL='http://localhost:8084/reservation/add';
const RESERVATION_DELETE_URL='http://localhost:8084/reservation';

class ReservationService{

    getAllReservations(){
        return axios.get(RESERVATION_GET_ALL_URL);
    }

    addReservations(reservation){
        return axios.post(RESERVATION_ADD_URL,reservation);
    }

    deleteReservation(reservationId){
        return axios.delete(RESERVATION_DELETE_URL + '/delete/' + reservationId);
    }
}
export default new ReservationService();