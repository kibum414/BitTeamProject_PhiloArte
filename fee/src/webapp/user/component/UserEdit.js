const userEdit = e => {
  e.preventDefault()

  const del = window.confirm("정보를 수정하시겠습니까?")

  if (del) {
   
    .then(res => {
      alert(`수정되었습니다.`)
      history.pushState('/profile/update-user')
      window.location.reload()
    }).catch(err => {
      alert(err)
    })
  }
}