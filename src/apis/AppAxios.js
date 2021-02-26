import axios from 'axios';
import {logout} from '../services/auth';

var AppAxios = axios.create({
  baseURL: 'http://localhost:8080/api',
  /* other custom settings */
});

 export const getFormati = async () => {
  try {
    let response = await AppAxios.get('/formati');
    return response.data;

   }
    catch (err) {
      console.log(err);
      return [];
}

}

AppAxios.interceptors.request.use(
  function success(config){
    const token = window.localStorage['jwt'];
    if (token){
      config.headers['Authorization'] = 'Bearer ' + token;
    }
    return config;
  }
);

AppAxios.interceptors.response.use(
  function uspeh(odgovor){
    return odgovor;
  },
  function neuspeh(greska){
    let token = window.localStorage.getItem('jwt');
    if(token){
      if(greska.response && greska.response.status === 403){
        logout();
      }
    }

    throw greska;
  }
);

export default AppAxios;
