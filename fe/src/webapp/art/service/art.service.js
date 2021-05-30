import axios from 'axios'

const list = (page) => axios.get(`http://localhost:8080/arts/list?page=${page}`)
const register = (payload) => axios.post(`http://localhost:8080/arts/register`, payload)
const upload = (payload) => axios.post(`http://localhost:8080/art_files/upload`, payload)
const read = (payload) => {
  console.log(payload)
  axios.get(`http://localhost:8080/arts/read/${payload}`)
}
const modify= (payload) => axios.put(`http://localhost:8080/arts/modify`, payload)
const del = (payload) => axios.delete(`http://localhost:8080/arts/delete`, payload)

export default { list, register, upload, read, modify, del }