import { combineReducers } from "redux";
import getFormatiReducers from "./GetFormatiReducers";

export default combineReducers ({
    formati: getFormatiReducers
});
