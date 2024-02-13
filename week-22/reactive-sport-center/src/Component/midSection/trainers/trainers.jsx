import Purchase from "../purchase/Purchase"
import Review from "../review/Review"
import "./trainer.css"

const Trainers = () => {
  return (
    <>
    <section className="section-first">
        <h2 className="title">OUR BEST TRAİNERS</h2>
        <div className="line"></div>
        <p className="margin-lr">Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem, ducimus voluptate nostrum ut sit magnam.</p>
    </section>
    <section className="section-first trainers">
        <div className="img-container">
            <div className="img-container-2">
                <img src="necessary-documents/photos/trainer1.jpg" alt="" />
                <div className="trainer-info">
                    <p className="trainer-text">July Merkel <br />Personel Trainer</p>
                </div>
            </div>
        </div>

        <div className="img-container">
            <div className="img-container-2">
                <img src="necessary-documents/photos/trainer2.jpg" alt="" />
                <div className="trainer-info">
                    <p className="trainer-text">John Add <br /> Personel Trainer</p>
                </div>
            </div>
        </div>

        <div className="img-container">
            <div className="img-container-2">
                <img src="necessary-documents/photos/trainer3.jpg" alt="" />
                <div className="trainer-info">
                    <p className="trainer-text">Jane Doe <br /> Cardio Trainer</p>
                </div>
            </div>
        </div>
    </section>
    <Purchase />
    <Review />
    </>
  )
}

export default Trainers