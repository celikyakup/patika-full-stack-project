import { useFormik } from "formik";
import { useEffect, useState } from "react";
import * as Yup from "yup";

const FormSchema = Yup.object().shape(
  {
    text: Yup.string().required("Bu alan boş olamaz"),
  },
  []
);

const ToDoList = () => {
  const [toDoList, setToDoList] = useState([]);
  const [status, setStatus] = useState("All");
  const [filteredTodos, setFilteredTodos] = useState([]);

  const { handleSubmit, values, handleChange, resetForm } = useFormik({
    initialValues: {
      text: "",
    },
    validationSchema: FormSchema,
    onSubmit: (value) => {
      setToDoList([
        ...toDoList,
        { text: value.text, completed: false, id: Math.random() },
      ]);
      resetForm();
    },
  });

  const filterHandler = () => {
    switch (status) {
      case "Completed":
        setFilteredTodos(toDoList.filter((toDo) => toDo.completed === true));
        break;
      case "Active":
        setFilteredTodos(toDoList.filter((toDo) => toDo.completed === false));
        break;
      default:
        setFilteredTodos([...toDoList]);
    }
  };

  useEffect(() => {
    getLocalTodolist();
  }, []);

  useEffect(() => {
    filterHandler(toDoList);
    saveLocalTodoList();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [toDoList, status]);

  const statusHandle = (e) => {
    setStatus(e.target.value);
  };

  const removeItem = (itemToRemove) => {
    const updateTodoList = [...toDoList];

    const indexToRemove = updateTodoList.indexOf(itemToRemove);
    if (indexToRemove !== -1) {
      updateTodoList.splice(indexToRemove, 1);
    }
    setToDoList(updateTodoList);
  };

  const toggleItem = (toDo) => {
    setToDoList(
      toDoList.map((item) => {
        if (item.id === toDo.id) {
          return {
            ...item,
            completed: !item.completed,
          };
        }
        return item;
      })
    );
  };

  const myButtons = [
    {
      name: "All",
      index: 0,
    },
    {
      name: "Active",
      index: 1,
    },
    {
      name: "Completed",
      index: 2,
    },
  ];

  const saveLocalTodoList = () => {
    localStorage.setItem("toDoList", JSON.stringify(toDoList));
  };

  const getLocalTodolist = () => {
    localStorage.getItem("toDoList")
      ? setToDoList(JSON.parse(localStorage.getItem("toDoList")))
      : [];
  };

  return (
    <div className="todo-con">
      <form onSubmit={handleSubmit}>
        <input
          id="text"
          name="text"
          type="text"
          className="new-todo"
          onChange={handleChange}
          value={values.text}
          placeholder="What needs to be done ?"
        />
      </form>
      <ul className="todo-list">
        {filteredTodos.map((toDo) => (
          <li key={toDo.id} className={toDo.completed ? "completed" : ""}>
            <input
              type="checkbox"
              className={"toggle" + (toDo.completed ? "" : "")}
              onChange={() => toggleItem(toDo)}
            />
            <label>{toDo.text}</label>
            <button
              className="destroy"
              onClick={() => removeItem(toDo)}
            ></button>
          </li>
        ))}
      </ul>
      <div className="buttons">
        {myButtons.map((button) => (
          <button
            key={button.index}
            onClick={() => statusHandle(event)}
            value={button.name}
            className={button.name === status ? "btn btn-selected" : "btn"}
          >
            {button.name}
          </button>
        ))}
      </div>
    </div>
  );
};

export default ToDoList;
