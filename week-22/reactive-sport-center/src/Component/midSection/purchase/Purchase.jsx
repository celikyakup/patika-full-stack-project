import "./purchase.css";
const Purchase = () => {
  return (
    <section className="third">
      <div>
        <h2 className="title">PURCHASE FROM US</h2>
        <div className="line"></div>
        <p className="margin-lr">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. A distinctio
          doloribus, magnam similique delectus voluptas.
        </p>
      </div>
      <div className="purchase text-center">
        <div className="card">
          <img src="necessary-documents/photos/purchase1.jpg" alt="" />
          <p className="medium-font">
            Kettlebell / 5kg <br />
            <span className="little-font">89,99$ / 59,99$</span>
          </p>
          <div>
            <span className="material-icons">shopping_cart</span>
            <span className="little-font">Add to card</span>
            <div></div>
          </div>
        </div>

        <div className="card">
          <img src="necessary-documents/photos/purchase2.jpg" alt="" />
          <p className="medium-font">
            Treadmill <br />
            <span className="little-font">899,99$ / 599,99$</span>
          </p>
          <div>
            <span className="material-icons">shopping_cart</span>
            <span className="little-font">Add to card</span>
            <div></div>
          </div>
        </div>

        <div className="card">
          <img src="necessary-documents/photos/purchase3.jpg" alt="" />
          <p className="medium-font">
            Adjustable Dumbbell <br />
            <span className="little-font">89,99$ / 59,99$</span>
          </p>
          <div>
            <span className="material-icons">shopping_cart</span>
            <span className="little-font">Add to card</span>
            <div></div>
          </div>
        </div>

        <div className="card">
          <img src="necessary-documents/photos/purchase4.jpg" alt="" />
          <p className="medium-font">
            Kettlebell / 3kg <br />
            <span className="little-font">89,99$ / 59,99$</span>
          </p>
          <div>
            <span className="material-icons">shopping_cart</span>
            <span className="little-font">Add to card</span>
            <div></div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default Purchase;
