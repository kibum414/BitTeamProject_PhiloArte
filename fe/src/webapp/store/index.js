import { combineReducers, configureStore, getDefaultMiddleware } from "@reduxjs/toolkit";
import logger from "redux-logger"
import arts from 'webapp/art/reducer/art.reducer'

const rootReducer = combineReducers({ arts });

export default configureStore({
    reducer: rootReducer,
    middleware: [...getDefaultMiddleware(), logger]
});