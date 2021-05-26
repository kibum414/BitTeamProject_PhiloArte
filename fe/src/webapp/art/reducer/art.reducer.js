import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import { ArtService } from 'webapp/art'

export const getArtList = createAsyncThunk("Art_LIST",
  async () => {
    const response = await ArtService.list()

    return response.data
  }
)

export const getArtRegister = createAsyncThunk("ART_REGISTER",
  async (args) => {
    const response = await ArtService.register(args)

    return response.data
  }
)

export const getArtRead = createAsyncThunk("ART_READ",
  async (args) => {
    const response = await ArtService.read(args)

    return response.data
  }
)

export const getArtModify = createAsyncThunk("ART_MODIFY",
  async (args) => {
    const response = await ArtService.modify(args)

    return response.data
  }
)

export const getArtDelete = createAsyncThunk("ART_DELETE",
  async (args) => {
    const response = await ArtService.del(args)

    return response.data
  }
)

const ArtSlice = createSlice({
  name: 'Arts',
  initialState: [],
  reducer: {},
  extraReducers: (builder) => {
    builder
      .addCase(getArtList.fulfilled, (state, { payload }) => {
        return [...payload]
      })
      .addCase(getArtRegister.fulfilled, (state, { payload }) => {
        alert(`등록 : ${payload}`)
      })
      .addCase(getArtRead.fulfilled, (state, { payload }) => {
        return [...payload]
      })
      .addCase(getArtModify.fulfilled, (state, { payload }) => {

      })
      .addCase(getArtDelete.fulfilled, (state, { payload }) => {

      })
  }
})

const { actions, reducer } = ArtSlice
export const { } = actions
export default reducer
