import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import { UserService } from '../index'

// 미들웨어
// 페이로드 생성자
// 비동기 + 콜백으로 되어 있기 때문에 호출될 때만 작동
export const getUserList = createAsyncThunk("users/findAll", async () => { // 액션 이름 및 비동기 호출 함수 정의
  const res = await UserService.fetch()
  return res.data
})

export const userSignUp = createAsyncThunk("signup", async (arg) => {
  const res = await UserService.signup(arg)
  return res.data
})

export const userSignIn = createAsyncThunk("signin", async (arg) => {
  const res = await UserService.signin(arg)
  return res.data
})

// 콜백 : 호출될 때만 작동
const isRejectedAction = action => (action.type.endsWith('rejected'))

// name, initialState, reducers, extraReducers 까지는 만들어짐
// extraReducers 내부는 호출되기 전까지는 없음
const userSlice = createSlice({
  name: 'users',
  initialState: [],
  reducers: {},
  extraReducers: (builder) => {
    builder
      // getUserList 성공 시
      .addCase(getUserList.fulfilled, (state, { payload }) => {
        alert(`3. 리덕스 내부 회원 목록 조회 성공 ${payload}`)

        return [...payload]
      })
      .addCase(userSignUp.fulfilled, (state, { payload }) => {
        return [...payload]
      })
      .addCase(userSignIn.fulfilled, (state, { payload }) => {
        alert(`Login Success ${JSON.stringify(payload)}`)
        
      })
      .addCase(userSignIn.rejected, (state, { payload }) => {
        alert(`Login Failed ${payload}`)
      })
      .addMatcher(isRejectedAction, () => { })
      .addDefaultCase((state, action) => { })
  }
})

// 리듀서 등록은 됨
const { actions, reducer } = userSlice
export const { } = actions
export default reducer