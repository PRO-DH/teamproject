import React, { Fragment } from "react";
import { Typography } from "@mui/material";

const content = (
  <Fragment>
    <Typography variant="h6" paragraph>
      솔루션 이름
    </Typography>
    <Typography paragraph>
    솔루션에 관한설명
    </Typography>
    <Typography paragraph>    
    설명
    </Typography>
    <Typography variant="h6" paragraph>
      솔루션 보유 기술
    </Typography>
    <Typography paragraph>    
    솔루션을 만들 때 사용한 기술 설명
    </Typography>
    <Typography paragraph>    
    기술1
    </Typography>
    <Typography paragraph>    
    기술2
    </Typography>
    <Typography paragraph>    
    하는 곳
    </Typography>
    <Typography variant="h6" paragraph>
      솔루션 응용처
    </Typography>
    <Typography paragraph>    
    이 솔루션을 사용할 곳
    </Typography>
    <Typography paragraph>    
    사용1
    </Typography>
  </Fragment>
);

const posts = [
  {
    title: "솔루션 1",
    id: 1,
    date: 1576281600,
    src: `${process.env.PUBLIC_URL}/images/logged_out/blogPost1.jpg`,
    snippet:
      "1. 솔루션 이름",
    content: content,
  },
  {
    title: "솔루션 2",
    id: 2,
    date: 1576391600,
    src: `${process.env.PUBLIC_URL}/images/logged_out/blogPost2.jpg`,
    snippet:
    "2. 솔루션 이름",
    content: content,
  },
  {
    title: "솔루션 3",
    id: 3,
    date: 1577391600,
    src: `${process.env.PUBLIC_URL}/images/logged_out/blogPost3.jpg`,
    snippet:
    "3. 솔루션 이름",
    content: content,
  },
  {
    title: "솔루션 4",
    id: 4,
    date: 1572281600,
    src: `${process.env.PUBLIC_URL}/images/logged_out/blogPost4.jpg`,
    snippet:
    "4. 솔루션 이름",
    content: content,
  },
  {
    title: "솔루션 5",
    id: 5,
    date: 1573281600,
    src: `${process.env.PUBLIC_URL}/images/logged_out/blogPost5.jpg`,
    snippet:
    "5. 솔루션 이름",
  },
  {
    title: "솔루션 6",
    id: 6,
    date: 1575281600,
    src: `${process.env.PUBLIC_URL}/images/logged_out/blogPost6.jpg`,
    snippet:
      "6. 솔루션 이름",
    content: content,
  },
];

export default posts;