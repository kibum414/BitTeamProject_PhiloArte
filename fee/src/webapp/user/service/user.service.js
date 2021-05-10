import axios from 'axios'

const fetch = () => axios.get(`http://localhost:8080/users/fetch`)
const signup = () => axios.get(`http://localhost:8080/users/signup`, {})

const register = () => {

    axios({
      url: `http://localhost:8080/users/signup`,
      method: 'post',
      headers: { 'Content-Type': 'application/json', 'Authorization': 'JWT fefege..' },
      data: {}
    })
}

const login = () => {
  axios({
    url: URL + '/users/signin',
    method: 'post',
    headers: { 'Content-Type': 'application/json', 'Authorization': 'JWT fefege..' },
    data: {}
  })
}

const edit = () => {
  axios({
    url: URL + user.userNum,
    method: 'put',
    headers: { 'Content-Type': 'application/json', 'Authoriztion': 'Bearer ' + localStorage.getItem("token") },
    data: {}
  })
}

const delete = () => {
  axios({
    url: URL + user.userNum,
    method: 'delete',
    headers: { 'Content-Type': 'application/json', 'Authorization': 'Bearer ' + localStorage.getItem("token") }
  })
}

export default { fetch, signup }