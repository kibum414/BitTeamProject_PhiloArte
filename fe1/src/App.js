import logo from './logo.svg';
import { Route } from 'react-router-dom';
import { Home } from './webapp/common';
import { Login, SignUp, UserList } from './webapp/user';

function App() {
  return (
    <div className="App">
      <Route exact path='/' component={Home} />

      <Route exact path='/signup' component={SignUp} />
      <Route exact path='/login' component={Login} />
      <Route exact path='/users' component={UserList} />
    </div>
  );
}

export default App;
