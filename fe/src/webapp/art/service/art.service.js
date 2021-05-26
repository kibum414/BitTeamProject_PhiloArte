import axios from 'axios'

const list = () => axios.get(`http://localhost:8080/arts/list`)
const register = (payload) => axios.post(`http://localhost:8080/arts/register`, payload)
const read = (payload) => axios.get(`http://localhost:8080/arts/read`, payload)
const modify= (payload) => axios.put(`http://localhost:8080/arts/modify`, payload)
const del = (payload) => axios.delete(`http://localhost:8080/arts/delete`, payload)

export default { list, register, read, modify, del }