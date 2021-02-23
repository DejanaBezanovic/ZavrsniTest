import React from 'react'

class Home extends React.Component {
  render() {
    return (
      <div>
        <h1>Najboji teniseri svih vremena</h1>
        <br/>
        <div class="row">
          <div class="col-4">
            <img src="https://imgresizer.eurosport.com/unsafe/1200x0/filters:format(jpeg):focal(1106x230:1108x228)/origin-imgresizer.eurosport.com/2021/02/12/2992728-61410288-2560-1440.jpg" style={{width:'100%'}}></img>
          </div>
          <div class="col-8">
            <p><strong>Novak Djokovic</strong></p>
          </div>
        </div>
        <br/><br/>
        <div class="row">
          <div class="col-4">
            <img src="https://media.npr.org/assets/img/2020/08/04/gettyimages-1209604287-3f36e54446a58d701d0c3a84a2f4e0025bd58d7d-s800-c85.jpg" style={{width:'100%'}}></img>
          </div>
          <div class="col-8">
            <p><strong>Rafael Nadal</strong></p>
          </div>
        </div>
        <br/><br/>
        <div class="row">
          <div class="col-4">
            <img src="https://www.cityam.com/wp-content/uploads/2020/01/1202443760.jpg" style={{width:'100%'}}></img>
          </div>
          <div class="col-8">
            <p><strong>Roger Federer</strong></p>
          </div>
        </div>
      </div>
    )
  }
}

export default Home;