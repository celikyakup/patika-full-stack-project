import { useState } from "react";
const btnText = {
  0: (
    <section className="btn-text" id="text-yoga">
      <div className="text">
        <h3 className="info-title">Why are your Yoga?</h3>
        <p className="info-text">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta
          inventore voluptas aut, vitae laborum iure.
        </p>
        <h3 className="lesson-day-title">When comes Yoga Your Time.</h3>
        <p className="lesson-day-text">
          Saturday-Sunday: 8:00am- 10:00am <br />
          Monday-Tuesday: 10:00am- 12:00pm <br />
          Wednesday-Friday: 3:00pm- 6:00pm
        </p>
      </div>
      <div className="image">
        <img src="necessary-documents/photos/yoga.jpg" alt="" />
      </div>
    </section>
  ),
  1: (
    <section className="btn-text " id="text-group">
      <div className="text">
        <h3 className="info-title">Why are your Group?</h3>
        <p className="info-text">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta
          inventore voluptas aut, vitae laborum iure.
        </p>
        <h3 className="lesson-day-title">When comes Group Your Time.</h3>
        <p className="lesson-day-text">
          Saturday-Sunday: 8:00am- 10:00am <br />
          Monday-Tuesday: 10:00am- 12:00pm <br />
          Wednesday-Friday: 3:00pm- 6:00pm
        </p>
      </div>
      <div className="image">
        <img src="necessary-documents/photos/group.webp" alt="" />
      </div>
    </section>
  ),
  2: (
    <section className="btn-text " id="text-solo">
      <div className="text">
        <h3 className="info-title">Why are your Solo?</h3>
        <p className="info-text">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta
          inventore voluptas aut, vitae laborum iure.
        </p>
        <h3 className="lesson-day-title">When comes Solo Your Time.</h3>
        <p className="lesson-day-text">
          Saturday-Sunday: 8:00am- 10:00am <br />
          Monday-Tuesday: 10:00am- 12:00pm <br />
          Wednesday-Friday: 3:00pm- 6:00pm
        </p>
      </div>
      <div className="image">
        <img src="necessary-documents/photos/solo.jpg" alt="" />
      </div>
    </section>
  ),
  3: (
    <section className="btn-text " id="text-strch">
      <div className="text">
        <h3 className="info-title">Why are your Streching?</h3>
        <p className="info-text">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta
          inventore voluptas aut, vitae laborum iure.
        </p>
        <h3 className="lesson-day-title">When comes Streching Your Time.</h3>
        <p className="lesson-day-text">
          Saturday-Sunday: 8:00am- 10:00am <br />
          Monday-Tuesday: 10:00am- 12:00pm <br />
          Wednesday-Friday: 3:00pm- 6:00pm
        </p>
      </div>
      <div className="image">
        <img src="necessary-documents/photos/stret.webp" alt="" />
      </div>
    </section>
  ),
};

const myButtons = [
  {
    name: "Yoga",
    index: 0,
  },
  {
    name: "Group",
    index: 1,
  },
  {
    name: "Solo",
    index: 2,
  },
  {
    name: "Streching",
    index: 3,
  },
];

const ButtonText = () => {
  const [btnIndex, setBtnIndex] = useState(0);

  const handleClick = (index) => {
    setBtnIndex(index);
  };

  return (
    < >
      <section
        style={{
          display: "flex",
          justifyContent: "space-around",
        }}
      >
        {myButtons.map((button) => (
          <button
            key={button.index}
            onClick={() => {
              handleClick(button.index);
            }}
            className={
              button.index === btnIndex ? "buttn buttn-focus" : "buttn"
            }
          >
            {button.name}
          </button>
        ))}
      </section>
      {btnText[btnIndex]}
    </>
  );
};

export default ButtonText;
