import {
  combineReducers,
  configureStore,
  getDefaultMiddleware,
} from "@reduxjs/toolkit";
import logger from 'redux-logger';
import todos from 'todo/reducer/todo.reducer'
import users from 'user/reducer/user.reducer'

const rootReducer = combineReducers({ todos, users })
export default configureStore({
  reducer: rootReducer,
  middleware: [...getDefaultMiddleware(), logger]
})