import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'
import { ArtService } from 'webapp/art'

export const getArtList = createAsyncThunk("ART_LIST",
  async (page) => {
    const response = await ArtService.list(page)

    return response.data
  }
)

export const getArtRegister = createAsyncThunk("ART_REGISTER",
  async (args) => {
    console.log('REGISTER : ' + JSON.stringify(args))
    const response = await ArtService.register(args)

    return response.data
  }
)

export const getArtUpload = createAsyncThunk("ART_UPLOAD",
  async (args) => {
    console.log('UPLOAD : ' + JSON.stringify(args))
    const response = await ArtService.upload(args)

    return response.data
  }
)

export const getArtRead = createAsyncThunk("ART_READ",
  async (args) => {
    console.log(args)
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

const artSlice = createSlice({
  name: 'arts',
  initialState: {
    pageResult: {
      dtoList: [],
      page: 1,
      pageList: [],
      start: 1,
      end: 1,
      prev: false,
      next: false
    },
    art: {},
    category: '',
    
  },
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(getArtList.fulfilled, (state, { payload }) => {
        state.pageResult = payload
        console.log(state.pageResult)
      })
      .addCase(getArtRegister.fulfilled, (state, { payload }) => {
        alert(`${payload}번 게시물 등록 완료 !`)
      })
      .addCase(getArtUpload.fulfilled, (state, { payload }) => {
        alert(`${payload} 파일 등록 완료 !`)
      })
      .addCase(getArtRead.fulfilled, (state, { payload }) => {
        state.art = payload
        console.log(state.art)
      })
      .addCase(getArtModify.fulfilled, (state, { payload }) => {

      })
      .addCase(getArtDelete.fulfilled, (state, { payload }) => {

      })
  }
})

const { actions, reducer } = artSlice
export const { } = actions
export default reducer
