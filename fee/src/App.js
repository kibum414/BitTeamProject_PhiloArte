import { Route } from 'react-router-dom';
import { Home } from 'webapp/common/index'
import { SignUp, Login, UserDetail, UserApp, UserEdit } from 'webapp/user/index'
import { News, SeoulCCTV } from 'webapp/board/index'
import { ArticleApp, ArticleWrite, ArticleDetail, ArticleUpdate } from 'webapp/article/index'
import { TodoApp } from 'webapp/todo/index'
import { ParticipantApp, ParticipantRegister, ParticipantDetail, ParticipantModify } from 'webapp/participant/index';

const App = () => {
  return (
    <div className="App">
      <Route exact path='/' component={Home} />
      <Route exact path='/signup' component={SignUp} />
      <Route exact path='/login' component={Login} />
      <Route exact path='/user' component={UserApp} />
      <Route exact path='/user/detail' component={UserDetail} />
      <Route exact path='/user/edit' component={UserEdit} />

      <Route exact path='/board/news' component={News} />
      <Route exact path='/board/seoul-cctv' component={SeoulCCTV} />
      <Route exact path='/todo' component={TodoApp} />

      <Route exact path='/article' component={ArticleApp} />
      <Route exact path='/article/write' component={ArticleWrite} />
      <Route exact path='/article/detail' component={ArticleDetail} />
      <Route exact path='/article/update' component={ArticleUpdate} />

      <Route exact path='/participants' component={ParticipantApp} />
      <Route exact path='/participants/register' component={ParticipantRegister} />
      <Route exact path='/participants/detail' component={ParticipantDetail} />
      <Route exact path='/participants/modify' component={ParticipantModify} />
    </div>
  );
}

export default App;
