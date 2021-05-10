import axios from 'axios'

const fetch = () => axios.get(`http://localhost:8080/users/fetch`)

const signup = ({ userInfo }) => {
  axios({
    url: `http://localhost:8080/users/signup`,
    method: 'post',
    headers: { 'Content-Type': 'application/json', 'Authorization': 'JWT fefege..' },
    data: {
      userInfo,
      regdate: new Date()
    }
  })
}

export default { fetch, signup }