import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import { WorkService } from 'webapp/work'

export const getWorkList = createAsyncThunk("WORK_LIST",
  async () => {
    const response = await WorkService.list()

    return response.data
  }
)

export const getWorkRegister = createAsyncThunk("WORK_REGISTER",
  async (args) => {
    const response = await WorkService.register(args)

    return response.data
  }
)

export const getWorkRead = createAsyncThunk("WORK_READ",
  async (args) => {
    const response = await WorkService.read(args)

    return response.data
  }
)

export const getWorkModify = createAsyncThunk("WORK_MODIFY",
  async (args) => {
    const response = await WorkService.modify(args)

    return response.data
  }
)

export const getWorkDelete = createAsyncThunk("WORK_DELETE",
  async (args) => {
    const response = await WorkService.del(args)

    return response.data
  }
)

const workSlice = createSlice({
  name: 'works',
  initialState: [],
  reducer: {},
  extraReducers: (builder) => {
    builder
      .addCase(getWorkList.fulfilled, (state, { payload }) => {
        return [...payload]
      })
      .addCase(getWorkRegister.fulfilled, (state, { payload }) => {
        alert(`등록 : ${payload}`)
      })
      .addCase(getWorkRead.fulfilled, (state, { payload }) => {
        return [...payload]
      })
      .addCase(getWorkModify.fulfilled, (state, { payload }) => {

      })
      .addCase(getWorkDelete.fulfilled, (state, { payload }) => {

      })
  }
})

const { actions, reducer } = workSlice
export const { } = actions
export default reducer
