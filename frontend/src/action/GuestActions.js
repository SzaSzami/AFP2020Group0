import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/GuestActionConstants'

export const recordGuest = ({name,age}) =>{
    axios.post('/guest/record',
        {
            name : name,
            age : age
        })
        .then(() => {
            fetchGuest();
            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
            fetchGuest();
        });
}

export const fetchGuest = () =>{

    axios.get('/guest/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}
