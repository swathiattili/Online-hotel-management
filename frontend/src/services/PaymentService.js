import axios from 'axios';
const PAYMENT_URL='http://localhost:9091';


class PaymentService{
    getPayment(payment){
        console.log("ndjs",payment)
        return axios.post(PAYMENT_URL+"/pay", payment)
    }

}
export default new PaymentService();