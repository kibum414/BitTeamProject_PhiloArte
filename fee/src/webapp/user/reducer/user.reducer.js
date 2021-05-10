import axios from 'axios'
import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import { UserService } from 'user/index'

// 미들웨어
// 페이로드 생성자
// 비동기 + 콜백으로 되어 있기 때문에 호출될 때만 작동
export const getUserList = createAsyncThunk(
  "users/fetch", // 액션 이름 정의
  async () => { // 비동기 호출 함수 정의
    alert(`getUserList`)
    const response = await UserService.fetch()

    return response.data
  }
)



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
      .addMatcher(isRejectedAction, () => { })
      .addDefaultCase((state, action) => { })
  }
})

// 리듀서 등록은 됨
const { actions, reducer } = userSlice
export const { } = actions
export default reducer