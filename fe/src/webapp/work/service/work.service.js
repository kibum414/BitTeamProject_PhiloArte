import axios from 'axios'

const list = () => axios.get(`http://localhost:8080/works/list`)
const register = (payload) => axios.post(`http://localhost:8080/works/register`, payload)
const read = (payload) => axios.get(`http://localhost:8080/works/read`, payload)
const modify= (payload) => axios.put(`http://localhost:8080/works/modify`, payload)
const del = (payload) => axios.delete(`http://localhost:8080/works/delete`, payload)

export default { list, register, read, modify, del }