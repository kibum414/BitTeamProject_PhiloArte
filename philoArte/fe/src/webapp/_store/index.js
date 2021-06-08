import { combineReducers, configureStore, getDefaultMiddleware } from '@reduxjs/toolkit';
import logger from 'redux-logger';
import artists from 'webapp/artist/reducer/artist.reducer';
import reviews from 'webapp/review/reducer/review.reducer';
import replies from 'webapp/reply/reducer/reply.reducer';
import resumes from 'webapp/resume/reducer/resume.reducer';
import arts from 'webapp/art/reducer/art.reducer';
import fundings from 'webapp/funding/reducer/funding.reducer';


const rootReducer = combineReducers({ artists, reviews, replies, resumes, arts, fundings });

//const persistedReducer = persistReducer(persistConfig, rootReducer);

export default configureStore({
    reducer: rootReducer,
    middleware: [...getDefaultMiddleware(), logger],
});
