// slice : name, state 라는 속성과 reducers 라는 기능이 합쳐진 것
import { createSlice } from '@reduxjs/toolkit'
import uuid from 'uuid/v4'

const initialState = {
  todoList: [
    { id: 3, text: '썽크 학습', done: false }
  ],
  doneTodoList: [
    { id: 1, text: '리액트 학습', done: true }, // done : 했는지 표시하는 것(중간 줄)
    { id: 2, text: '리덕스 학습', done: true },
  ]
}

// 기능: addTodo, todos, findTodo, editTodo, delTodo
const todoSlice = createSlice({
  name: 'todoSlice',
  // initialState: initialState,
  initialState,
  reducers: {
    // Enhanced Object Literal
    addTodo(state, { payload }) { // FSA : 액션 타입 + payload(속성값)
      state.todoList.push({ id: uuid(), text: payload, done: false })
    },
    deleteTodo(state, { payload }) {
      if (payload.done) {
        state.doneTodoList.splice(state.doneTodoList.findIndex(todo => todo.id === payload.id), 1)
      } else {
        state.todoList.splice(state.todoList.findIndex(todo => todo.id === payload.id), 1)
      }

      /*  filter 사용
      return state.todoList.filter(todo => todo.id !== payload)
      */
    },
    deleteAllTodo(state, { payload }) {
      //state.todoList.length = 0

      if (payload[0].done) {
        state.doneTodoList.splice(payload)
      } else {
        state.todoList.splice(payload)
      }
    },
    toggleTodo(state, { payload }) {
      if (payload.done) {
        const index = state.doneTodoList.findIndex(todo => todo.id === payload.id)
        state.doneTodoList[index].done = !state.doneTodoList[index].done

        state.todoList.push(state.doneTodoList[index])
        state.doneTodoList.splice(index, 1)
      } else {
        const index = state.todoList.findIndex(todo => todo.id === payload.id)
        state.todoList[index].done = !state.todoList[index].done

        state.doneTodoList.push(state.todoList[index])
        state.todoList.splice(index, 1)
      }

      // const toggle = state.todoList.find(todo => todo.id === payload)
      // toggle.done = !toggle.done

      // if (toggle.done) {
      //   state.doneTodoList.push(toggle)
      //   state.todoList.splice(state.todoList.findIndex(todo => todo.id === payload), 1)
      // }
    },

  }
})

const { actions, reducer } = todoSlice
export const { addTodo, deleteTodo, deleteAllTodo, toggleTodo } = actions
export default reducer