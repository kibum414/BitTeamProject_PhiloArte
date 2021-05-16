

const UserEdit = () =>
(
  <form style={{ border: "1px solid #ccc" }}>
    <div className="container">
      <h1>User Edit</h1>
      <hr />

      <label for="name"><b>Name</b></label>
      <input type="text" name="name" readOnly />

      <label for="email"><b>Email</b></label>
      <input type="text" name="email" readOnly />

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required />

      <label for="psw-repeat"><b>Repeat Password</b></label>
      <input type="password" placeholder="Repeat Password" name="psw-repeat" required />

      <label for="phone"><b>Phone Number</b></label>
      <input type="text" placeholder="Enter Phone Number" name="phone" />

      <label for="address"><b>Address</b></label>
      <input type="text" placeholder="Enter Address" name="address" />

      <div className="clearfix">
        <button type="button" className="cancelbtn">Cancel</button>
        <button type="submit" className="editbtn">Edit</button>
      </div>
    </div>
  </form>
)

export default UserEdit