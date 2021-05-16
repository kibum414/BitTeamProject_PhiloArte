import axios from 'axios'

const fetch = () => axios.get(`http://localhost:8080/users/fetch`)

const signup = (payload) => {
  return axios({
    url: `http://localhost:8080/users/signup`,
    method: 'post',
    headers: { 'Content-Type': 'application/json', 'Authorization': 'JWT fefege..' },
    data: payload
  })
}

const signin = (payload) => {
  return axios({
    url: `http://localhost:8080/users/signin`,
    method: 'post',
    headers: { 'Content-Type': 'application/json', 'Authorization': 'JWT fefege..' },
    data: payload
  })
}

export default { fetch, signup, signin }